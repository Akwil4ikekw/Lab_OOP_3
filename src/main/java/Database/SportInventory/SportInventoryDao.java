package Database.SportInventory;

import Database.Dao.BaseDaoImplements;
import org.example.Table.SportInventory;

public class SportInventoryDao extends BaseDaoImplements<SportInventory> {

    @Override
    protected Class<SportInventory> getEntityClass() {
        return SportInventory.class;
    }
}
