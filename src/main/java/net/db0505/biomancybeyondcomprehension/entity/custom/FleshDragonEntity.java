package net.db0505.biomancybeyondcomprehension.entity.custom;

import net.db0505.biomancybeyondcomprehension.client.ModKeyBindings;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class FleshDragonEntity extends PathfinderMob {

    public final AnimationState idleGroundAnimationState = new AnimationState();
    public final AnimationState HoveringAnimationState = new AnimationState();
    private int idleGroundAnimationTimeout = 0;
    private int HoveringAnimationTimeout = 0;

    private boolean hovering = false;
    private int hoveringCooldown = 100;

    public FleshDragonEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.setMaxUpStep(1.0F);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        if (!this.isVehicle() && !this.isBaby()) {
            this.doPlayerRide(pPlayer);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
        else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    protected void doPlayerRide(Player pPlayer) {
        if (!this.level().isClientSide) {
            pPlayer.setYRot(this.getYRot());
            pPlayer.setXRot(this.getXRot());
            pPlayer.startRiding(this);
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide) {
            setupAnimationState();
        }

        if (this.isVehicle()) {
            Entity rider = this.getFirstPassenger();

            if (rider instanceof Player player) {
                // jump = start hovering
                if (hoveringCooldown > 0)
                {
                    hoveringCooldown -= 1;
                }

                if (!hovering && hoveringCooldown < 1) {
                    if (ModKeyBindings.INSTANCE.FlyUp.consumeClick()) {
                        setHovering(true);
                    }
                }
                // grounded = stop hovering
                if (hovering && hoveringCooldown < 1) {
                    if (this.onGround()) {
                        setHovering(false);
                    }
                }
            }
        }
    }

    public void setHovering(boolean hovering) {
        this.hovering = hovering;

        if (hovering) {
            this.setNoGravity(true);
            this.navigation = new FlyingPathNavigation(this, level());
            this.HoveringAnimationState.start(this.tickCount);
            hoveringCooldown = 100;
        } else {
            this.setNoGravity(false);
            this.navigation = new GroundPathNavigation(this, level());
            this.idleGroundAnimationState.start(this.tickCount);
            hoveringCooldown = 100;
        }
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isAlive() && this.isVehicle() && this.getControllingPassenger() instanceof Player rider) {

            this.setYRot(rider.getYRot());
            this.yRotO = this.getYRot();

            float forward = rider.zza;
            float strafe = rider.xxa;

            if (hovering) {

                // vertical movement
                double vertical = 0;

                if (ModKeyBindings.INSTANCE.FlyUp.isDown()) {
                    vertical = 50;
                    System.out.println("Flyup!");
                }

                if (ModKeyBindings.INSTANCE.FlyDown.isDown()) {
                    vertical = -50;
                    System.out.println("FlyDown!");
                }

                super.travel(new Vec3(strafe, vertical, forward));

            } else {
                super.travel(new Vec3(strafe, travelVector.y, forward));
            }

            return;
        }

        super.travel(travelVector);
    }

    protected void tickRidden(Player pPlayer, Vec3 pTravelVector) {
        super.tickRidden(pPlayer, pTravelVector);
        Vec2 vec2 = this.getRiddenRotation(pPlayer);
        this.setRot(vec2.y, vec2.x);
        this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
    }

    protected Vec2 getRiddenRotation(LivingEntity pEntity) {
        return new Vec2(pEntity.getXRot() * 0.5F, pEntity.getYRot());
    }

    protected Vec3 getRiddenInput(Player pPlayer, Vec3 pTravelVector) {
        if (this.onGround()) {
            return Vec3.ZERO;
        } else {
            float f = pPlayer.xxa * 0.5F;
            float f1 = pPlayer.zza;
            if (f1 <= 0.0F) {
                f1 *= 0.25F;
            }

            return new Vec3((double)f, 0.0D, (double)f1);
        }
    }

    protected void positionRider(Entity pPassenger, Entity.MoveFunction pCallback) {
        super.positionRider(pPassenger, pCallback);
        float f = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F));
        float f1 = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F));
        pCallback.accept(pPassenger, this.getX() + (double)(f), this.getY() + this.getPassengersRidingOffset() + pPassenger.getMyRidingOffset(), this.getZ() - (double)(f1));
        if (pPassenger instanceof LivingEntity) {
            ((LivingEntity)pPassenger).yBodyRot = this.yBodyRot;
        }
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        Entity entity = this.getFirstPassenger();
        if (entity instanceof Mob) {
            return (Mob)entity;
        } else {
            entity = this.getFirstPassenger();
            if (entity instanceof Player) {
                return (Player)entity;
            }

            return null;
        }
    }

    protected float getRiddenSpeed(Player pPlayer) {
        return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED);
    }

    public boolean isHovering() {
        return hovering;
    }

    private void setupAnimationState() {
        /*
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleGroundAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
         */
    }

    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source) {
        return !hovering && super.causeFallDamage(fallDistance, multiplier, source);
    }
}
