package com.loves.designModel.createModel.factory.version02;

public class BuildCreator implements Creator{

    public Light createLight() {
        return new BuildLight();
    }
}
