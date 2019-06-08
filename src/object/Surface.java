package object;

import basics.MaterialSolid;
import basics.MaterialTextured;
import basics.Vec3;

public interface Surface {
    double calculateIntersection(Vec3 position, Vec3 direction);

    MaterialTextured getMaterialTextured();
    MaterialSolid getMaterialSolid();
}
