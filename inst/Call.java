package moe.wjk.ir.inst;

import java.util.Arrays;

import moe.wjk.ir.Instruction;

public class Call extends Instruction {
    // keep sync with JNIValue
    public long[] callstring; // context+callsite
    public String target;
    public long callsite;

    @Override
    public String getOpString() {
        return "Call "+target;
    }

    @Override
    public String toString() {
        if (callsite != 0) {
            if (comments == null) {
                comments = String.format("context: %s, callsite: %s", Arrays.toString(callstring), Long.toHexString(callsite));
            } else {
                comments += String.format(" context: %s, callsite: %s", Arrays.toString(callstring), Long.toHexString(callsite));
            }
        }
        return super.toString();
    }
}
