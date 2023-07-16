package moe.wjk.ir.inst;

import com.google.gson.JsonElement;
import moe.wjk.ir.Instruction;

import java.util.Arrays;
import java.util.List;

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
        return super.toString() + String.format("\t ; context: %s, callsite: %s", Arrays.toString(callstring), callsite);
    }
}
