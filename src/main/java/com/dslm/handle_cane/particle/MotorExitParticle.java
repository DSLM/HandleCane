package com.dslm.handle_cane.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MotorExitParticle extends TextureSheetParticle
{
    MotorExitParticle(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed)
    {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.gravity = 0.75F;
        this.friction = 0.999F;
        this.xd *= 1.4F;
        this.yd *= 0.8F;
        this.zd *= 1.4F;
        //this.yd = this.random.nextFloat() * 0.4F + 0.05F;
        this.quadSize *= this.random.nextFloat() * 2.0F + 0.2F;
        this.lifetime = (int) (16.0D / (Math.random() * 0.8D + 0.2D));
    }
    
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }
    
    public int getLightColor(float pPartialTick)
    {
        int i = super.getLightColor(pPartialTick);
        int j = 240;
        int k = i >> 16 & 255;
        return 240 | k << 16;
    }
    
    public float getQuadSize(float pScaleFactor)
    {
        float f = ((float) this.age + pScaleFactor) / (float) this.lifetime;
        return this.quadSize * (1.0F - f * f);
    }
    
    public void tick()
    {
        super.tick();
        if(!this.removed)
        {
            float f = (float) this.age / (float) this.lifetime;
            if(this.random.nextFloat() > f)
            {
                this.level.addParticle(ParticleTypes.SMOKE, this.x, this.y, this.z, this.xd, this.yd, this.zd);
            }
        }
        
    }
    
    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet sprite;
        
        public Provider(SpriteSet sprites)
        {
            this.sprite = sprites;
        }
        
        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed)
        {
            MotorExitParticle motorExitParticle = new MotorExitParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            motorExitParticle.pickSprite(this.sprite);
            return motorExitParticle;
        }
    }
}