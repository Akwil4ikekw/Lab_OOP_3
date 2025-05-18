package Database.Warehouse;

import Database.Dao.BaseDaoImplements;
import org.example.Table.Warehouse;

public class WarehouseDao extends BaseDaoImplements<Warehouse> {

    @Override
    protected Class<Warehouse> getEntityClass() {
        return Warehouse.class;
    }

}

