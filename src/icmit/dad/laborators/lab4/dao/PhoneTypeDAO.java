package icmit.dad.laborators.lab4.dao;

import icmit.dad.laborators.lab4.domain.PhoneType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneTypeDAO extends GenericDAOImpl<PhoneType> {

    @Override
    public PhoneType create(PhoneType o) {
        String sql =
                "insert into dict_phonetype (id, name, fullname, code) values ( ? , ? , ? , ? ) ";

        if(o.getId()==null){
            o.setId(db.generateId("phonetype_id"));
        }

        try (PreparedStatement st = db.getConnection().prepareStatement(sql)){

            st.setLong(1, o.getId());
            st.setString(2, o.getName());
            st.setString( 3, o.getFullName());
            st.setString( 4, o.getCode());

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            o = null;
        }

        return o;
    }

    @Override
    public void update(PhoneType o) {
        String sql =
                "update dict_phonetype set name = ? , fullname = ? , code = ? where id = ? ";

        try (PreparedStatement st = db.getConnection().prepareStatement(sql)){

            st.setString(1, o.getName());
            st.setString( 2, o.getFullName());
            st.setString( 3, o.getCode());
            st.setLong(4, o.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(PhoneType o) {
        String sql =
                "delete from dict_phonetype  where id = ? ";

        try (PreparedStatement st = db.getConnection().prepareStatement(sql)){

            st.setLong(1, o.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PhoneType> getAll() {
        List<PhoneType> result = new ArrayList<>();
        String sql =
                "select * from dict_phonetype ";

        try (PreparedStatement st = db.getConnection().prepareStatement(sql)){
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                PhoneType o = new PhoneType();
                o.setId(rs.getLong("id"));
                o.setName(rs.getString("name"));
                o.setFullName(rs.getString("fullname"));
                o.setCode(rs.getString("code"));

                result.add(o);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public PhoneType getByKey(Long id) {
        return null;
    }

    @Override
    public PhoneType getByName(String name) {
        return null;
    }

    @Override
    public PhoneType getByCode(String code) {
        return null;
    }
}
