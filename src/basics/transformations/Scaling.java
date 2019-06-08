package basics.transformations;

import basics.Vec3;

public class Scaling implements Transformations {
    private Vec3 vec3;

    public Scaling(Vec3 vec3) {
        this.vec3 = vec3;
    }

    public Scaling() {
    }

    public Vec3 getVec3() {
        return vec3;
    }

    public void setVec3(Vec3 vec3) {
        this.vec3 = vec3;
    }
}
