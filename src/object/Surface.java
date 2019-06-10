package object;

import basics.MaterialSolid;
import basics.MaterialTextured;
import basics.Vec3;

public interface Surface {
    double calculateIntersection(Vec3 position, Vec3 direction);
    public Vec3 calculateNormal(Vec3 point);

    MaterialTextured getMaterialTextured();
    MaterialSolid getMaterialSolid();

    int calculatePhongColor(Vec3 point, Vec3 position);
}
