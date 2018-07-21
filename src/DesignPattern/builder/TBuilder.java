package DesignPattern.builder;

public class TBuilder {
	private final String name;
	private final String type;
	private final int length;
	private final String color;

	TBuilder(final String name, final String type, final int length, final String color) {
		this.name = name;
		this.type = type;
		this.length = length;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getLength() {
		return length;
	}

	public String getColor() {
		return color;
	}

	/** create Builder method **/
	public static TBuilder.Builder custom() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "TBuilder  名称：" + name + " 型号：" + type + " 颜色：" + color +"  长度：" + length;
	}
      // 这才是关键 静态内部类
	public static class Builder {
		private String name;
		private String type;
		private int length;
		private String color;

		Builder() {
			this.name = "";
			this.type = "";
			this.length = 0;
			this.color = "";
		}

		public Builder setName(final String name) {
			this.name = name;
			return this;
		}

		public Builder setType(final String type) {
			this.type = type;
			return this;
		}

		public Builder setLength(final int length) {
			this.length = length;
			return this;
		}

		public Builder setColor(final String color) {
			this.color = color;
			return this;
		}

		public TBuilder build() {
			return new TBuilder(name, type, length, color);
		}
	}

}
