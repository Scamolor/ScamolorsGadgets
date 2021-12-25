// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

public static class Modelend_crystal_no_base extends EntityModel<Entity> {
	private final ModelRenderer cube;
	private final ModelRenderer glass;

	public Modelend_crystal_no_base() {
		texWidth = 64;
		texHeight = 32;

		cube = new ModelRenderer(this);
		cube.setPos(0.0F, 14.0F, 0.0F);
		cube.texOffs(32, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		glass = new ModelRenderer(this);
		glass.setPos(0.0F, 14.0F, 0.0F);
		glass.texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		cube.render(matrixStack, buffer, packedLight, packedOverlay);
		glass.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.glass.xRot = ageInTicks;
		this.cube.xRot = ageInTicks;
	}
}