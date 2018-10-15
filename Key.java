public class Key {

	private int num;
	private int weight;

	public Key(int num, int weight) {
		this.num = num;
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Key) {

			Key foreignKey = (Key) obj;
			return this.num == foreignKey.num && this.weight == foreignKey.weight;
		}
		else {

			return false;
		}
	}

	@Override
	public int hashCode() {

		//Cantor pairing function
		return (num+weight)*(num+weight+1)/2+weight;
	}
}