public enum GateType {
    NORMAL_GATE("|"),SENSOR_GATE("$");

    private String valueType;

    GateType(String valueType) {
        this.valueType = valueType;
    }
}
