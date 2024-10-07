package org.voomega.sandbox.test.generics.domain.models;

import java.util.Collection;

public class SensorZone<S extends Sensor> {
    public Position position;
    public Orientation orientation;

    public Collection<S> sensors;
}
