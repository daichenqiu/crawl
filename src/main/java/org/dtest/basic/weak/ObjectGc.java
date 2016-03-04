package org.dtest.basic.weak;


@SuppressWarnings({"rawtypes","unchecked","unused"})
public class ObjectGc {

	public ObjectGc() {}

	public static void main(String [] args) {
	ObjectGc og = new ObjectGc();
	//很明显,og没有存在的意义了
	og = null;
	System.gc();
	}
	//当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
	protected void finalize() {
	System.out.println("我已经被垃圾回收器回收了...");
	}
	
}
