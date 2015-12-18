package p.minn.weixin.util;

/**
 * 
 * @author minn
 * @QQ:3942986006
 *
 */

public enum EncryptType {
	PLAINTEXT(0),COMPATIBLE(1),SAFETY(2);
	
	private int value;

	private EncryptType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static EncryptType getType(int v){
		switch(v){
		case 0:
			return PLAINTEXT;
		case 1:
			return COMPATIBLE;
		case 2:
			return SAFETY;
		default :
				return null;
		}
		
	}
	
}
