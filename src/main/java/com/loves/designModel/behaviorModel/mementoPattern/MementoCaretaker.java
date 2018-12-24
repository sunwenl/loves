package com.loves.designModel.behaviorModel.mementoPattern;

import java.util.HashMap;

public class MementoCaretaker {
	private HashMap<String, MementoIF> mementomap =new HashMap<String, MementoIF>();

	/**
	 * 恢复方法
	 * @param name
	 * @return
	 */
	public MementoIF retrieveMemento(String name) {
		return mementomap.get(name);
	}
	/**
	 * 备忘录赋值方法
	 */
	public void saveMemento(String name, MementoIF memento) {
		this.mementomap.put(name, memento);
	}
}
