package com.ccc.funny.entity.ai;

import com.ccc.funny.entity.custom.KobeBryantEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class KobeBryantAttackGoal extends MeleeAttackGoal {
    private final KobeBryantEntity entity;
    private int attackDelay = 10;
    private int tickUntilNextAttack = 4;
    private boolean shouldCountTillNextAttack = false;
    public KobeBryantAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        this.entity = (KobeBryantEntity) mob;
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        tickUntilNextAttack = 20;
    }

    @Override
    public void stop() {
        super.stop();
        entity.setAttacking(false);
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack){
            this.tickUntilNextAttack = Math.max(this.tickUntilNextAttack - 1 ,0);
        }
    }

    @Override
    protected void attack(LivingEntity target, double squaredDistance) {
        if (isEnemyWithinAttackDistanse(target, squaredDistance)) {
            shouldCountTillNextAttack = true;

            if (isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }
            if (isTimeToAttack()){
                this.mob.getLookControl().lookAt(target.getX(),target.getY(),target.getZ());
                preformAttack(target);
            }
        }else {
            resetAttackCoolDown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeOut = 0;
        }
    }

    private void resetAttackCoolDown() {
        this.tickUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    private void preformAttack(LivingEntity target) {
        this.resetAttackCoolDown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(target);
    }

    private boolean isTimeToAttack() {
        return this.tickUntilNextAttack <= 0;
    }

    private boolean isTimeToStartAttackAnimation() {
        return this.tickUntilNextAttack <= attackDelay;
    }

    private boolean isEnemyWithinAttackDistanse(LivingEntity target, double squaredDistance) {
        return squaredDistance <= this.getSquaredMaxAttackDistance(target);
    }
    //net/minecraft/client/gui/screen/SplashOverlay
}
