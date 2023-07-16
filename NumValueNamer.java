package moe.wjk.ir;

import moe.wjk.ir.utils.Constant;
import moe.wjk.ir.utils.Type;
import moe.wjk.ir.utils.Value;

public class NumValueNamer {
    long count = 0;

    public void visitModule(Module m) {
        m.funcs.forEach(this::visitFunc);
    }

    public void visitFunc(Function f) {
        count = 0;
        f.params.forEach(this::visitValue);
        f.insts.forEach(this::visitInst);
    }

    public void visitInst(Instruction i) {
        visitValue(i);
        i.getUses().forEach(use -> visitValue(use.value));
    }

    public void visitValue(Value i) {
        if ((i.type == null || i.type.ty == null || !i.type.ty.equals(Type.BaseType.VOID)) && i.name == null && (!(i instanceof Constant))) {
            i.name = String.valueOf(count++);
        }
    }
}
