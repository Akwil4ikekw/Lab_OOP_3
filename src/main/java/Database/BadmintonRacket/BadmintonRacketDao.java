package Database.BadmintonRacket;

import Database.Dao.BaseDaoImplements;
import org.example.Table.BadmintonRacket;
import org.example.Table.Shuttlecock;

public class BadmintonRacketDao  extends BaseDaoImplements<BadmintonRacket> {
    @Override
    protected Class<BadmintonRacket> getEntityClass() {
        return BadmintonRacket.class;
    }

}
