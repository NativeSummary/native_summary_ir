package moe.wjk.ir;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Module implements Serializable {
    public String apk_name;
    public String so_name;
    public int defaultPointSize;
    public List<Function> funcs = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (apk_name != null) {
            sb.append("source_filename = \"").append(apk_name).append("\"\n");
        }
        if (so_name != null) {
            sb.append("native_object_filename = \"").append(so_name).append("\"\n");
        }
        if (defaultPointSize != 0) {
            sb.append("pointer_size = \"").append(defaultPointSize).append("\"\n");
        }
        sb.append("\n");
        for (Function f: funcs) {
            sb.append(f.toString());
            sb.append("\n\n");
        }
        return sb.toString();
    }

    /**
     * 对Function去重以确保正确性，目前Function和Module之间还不耦合，所以直接添加即可。
     * @param ms
     * @return
     */
    public static Module merge(List<Module> ms) {
        if (ms.size() == 0) return null;
        Module ret = ms.get(0);
        Set<String> dup = new HashSet<>();
        for (Module m: ms) {
            for(Function f: m.funcs) {
                boolean added = dup.add(f.clazz+"\t"+f.name+"\t"+f.signature);
                if (!added) {
                    System.out.println(String.format("Warning: duplicate function: %s %s %s", f.clazz, f.name, f.signature));
                }
                if (m != ret && added) {
                    ret.funcs.add(f);
                }
            }
        }
        return ret;
    }
}
