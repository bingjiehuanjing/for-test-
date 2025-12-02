/*     */ package rikuto.manaita_plus.entity;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.vecmath.AxisAngle4d;
/*     */ import javax.vecmath.Matrix4d;
/*     */ import javax.vecmath.Tuple3d;
/*     */ import javax.vecmath.Vector3d;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityTippedArrow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.world.World;
/*     */ import rikuto.manaita_plus.item.IManaitaConfigurable;
/*     */ import rikuto.manaita_plus.util.ManaitaPlusUtils;
/*     */ 
/*     */ 
/*     */ public class EntityManaitaArrow
/*     */   extends EntityTippedArrow
/*     */ {
/*     */   public Entity target;
/*     */   protected double area;
/*     */   protected boolean attackFrendlyMob;
/*     */   
/*     */   public EntityManaitaArrow(World world) {
/*  27 */     super(world);
/*     */   }
/*     */   
/*     */   public EntityManaitaArrow(World world, EntityLivingBase living, Entity entity, ItemStack itemStack) {
/*  31 */     super(world, living);
/*  32 */     this.target = entity;
/*  33 */     this.area = (itemStack.func_77978_p().func_74762_e(IManaitaConfigurable.EnumConfig.ATTACK_AREA.func_176610_l()) - 1);
/*  34 */     this.attackFrendlyMob = itemStack.func_77978_p().func_74767_n(IManaitaConfigurable.EnumConfig.ATTACK_FRIENDLY_MOB.func_176610_l());
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  38 */     if (this.field_70173_aa >= 1200) {
/*  39 */       func_70106_y();
/*     */     }
/*  41 */     if (this.field_70173_aa > 3 && !this.field_70254_i && this.target != null) {
/*  42 */       Vector3d arrowLoc = new Vector3d(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  43 */       Vector3d targetLoc = new Vector3d(this.target.field_70165_t, this.target.field_70163_u + (this.target.field_70131_O / 2.0F), this.target.field_70161_v);
/*     */       
/*  45 */       Vector3d lookVec = new Vector3d(targetLoc);
/*  46 */       lookVec.sub((Tuple3d)arrowLoc);
/*     */       
/*  48 */       Vector3d arrowMotion = new Vector3d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       
/*  50 */       double theta = wrap180Radian(arrowMotion.angle(lookVec));
/*  51 */       theta = clampAbs(theta, 1.5707963267948966D);
/*     */       
/*  53 */       Vector3d crossProduct = new Vector3d();
/*  54 */       crossProduct.cross(arrowMotion, lookVec);
/*  55 */       crossProduct.normalize();
/*     */       
/*  57 */       Matrix4d transform = new Matrix4d();
/*  58 */       transform.set(new AxisAngle4d(crossProduct, theta));
/*     */       
/*  60 */       Vector3d adjustedLookVec = new Vector3d(arrowMotion);
/*  61 */       transform.transform(arrowMotion, adjustedLookVec);
/*     */       
/*  63 */       func_70186_c(adjustedLookVec.x, adjustedLookVec.y, adjustedLookVec.z, 10.0F, 0.0F);
/*     */     } 
/*     */     
/*  66 */     super.func_70071_h_();
/*     */   }
/*     */   
/*     */   protected void func_184549_a(RayTraceResult traceResult) {
/*  70 */     Entity victim = ManaitaPlusUtils.getEntity(traceResult.field_72308_g);
/*  71 */     if (this.field_70250_c instanceof EntityPlayer && victim != null) {
/*  72 */       EntityPlayer player = (EntityPlayer)this.field_70250_c;
/*     */       
/*  74 */       List<Entity> entities = this.field_70170_p.func_72872_a(Entity.class, victim.func_174813_aQ().func_186662_g(this.area));
/*  75 */       entities.remove(player);
/*     */       
/*  77 */       for (Entity entity : entities) {
/*  78 */         Entity target = ManaitaPlusUtils.getEntity(entity);
/*     */         
/*  80 */         if (target == null || (
/*  81 */           !victim.equals(target) && !(target instanceof net.minecraft.entity.monster.IMob) && !this.attackFrendlyMob))
/*     */           continue; 
/*  83 */         ManaitaPlusUtils.instantKill(entity, (EntityLivingBase)player);
/*     */       } 
/*     */     } 
/*     */     
/*  87 */     func_70106_y();
/*     */   }
/*     */   
/*     */   protected void func_184548_a(EntityLivingBase living) {
/*  91 */     super.func_184548_a(living);
/*     */   }
/*     */   
/*     */   private double wrap180Radian(double radian) {
/*  95 */     radian %= 6.283185307179586D;
/*  96 */     while (radian >= Math.PI)
/*  97 */       radian -= 6.283185307179586D; 
/*  98 */     while (radian < -3.141592653589793D)
/*  99 */       radian += 6.283185307179586D; 
/* 100 */     return radian;
/*     */   }
/*     */   
/*     */   private double clampAbs(double param, double maxMagnitude) {
/* 104 */     if (Math.abs(param) > maxMagnitude)
/* 105 */       if (param < 0.0D) {
/* 106 */         param = -Math.abs(maxMagnitude);
/*     */       } else {
/* 108 */         param = Math.abs(maxMagnitude);
/* 109 */       }   return param;
/*     */   }
/*     */ }


/* Location:              H:\mc 開發用\Manaita+Plus-1.12.2-1.0.1.zip!\rikuto\manaita_plus\entity\EntityManaitaArrow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */