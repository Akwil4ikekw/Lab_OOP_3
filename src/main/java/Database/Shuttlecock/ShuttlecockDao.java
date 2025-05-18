package Database.Shuttlecock;

import Database.Dao.BaseDaoImplements;
import org.example.Table.Shuttlecock;

public class ShuttlecockDao  extends BaseDaoImplements<Shuttlecock> {

    @Override
    protected Class<Shuttlecock> getEntityClass() {
        return Shuttlecock.class;
    }
}
