package moe.wjk.ir;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
}
