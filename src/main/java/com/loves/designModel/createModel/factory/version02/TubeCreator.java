package com.loves.designModel.createModel.factory.version02;

public class TubeCreator implements Creator{

    public Light createLight() {
        return new TubeLight();
    }

}
