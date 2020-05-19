package elasticjob;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtil {
    //url
    private static String url = "jdbc:mysql://localhost:3306/job?characterEncoding=utf8&useSSL=false";
    //user
    private static String user = "root";
    //password
    private static String password = "123456";
    //驱动程序类
    private static String driver = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        if (con != null) {
                            try {
                                con.close();
                            } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }


    /***
     * DML操作（增删改）
     * 1.获取连接数据库对象
     * 2.预处理
     * 3.执行更新操作
     * @param sql
     * @param obj
     */
    //调用者只需传入一个sql语句，和一个Object数组。该数组存储的是SQL语句中的占位符
    public static void executeUpdate(String sql,Object...obj) {
        Connection con = getConnection();//调用getConnection()方法连接数据库
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);//预处理
            for (int i = 0; i < obj.length; i++) {//预处理声明占位符
                ps.setObject(i + 1, obj[i]);
            }
            ps.executeUpdate();//执行更新操作
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close(null, ps, con);//调用close()方法关闭资源
        }
    }



    /***
     * DQL查询
     * Result获取数据集
     *
     * @param sql
     * @param obj
     * @return
     */
    public static List<Map<String,Object>> executeQuery(String sql, Object...obj) {
        Connection con = getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            rs = ps.executeQuery();
            //new 一个空的list集合用来存放查询结果
            List<Map<String, Object>> list = new ArrayList<>();
            //获取结果集的列数
            int count = rs.getMetaData().getColumnCount();
            //对结果集遍历每一条数据是一个Map集合，列是k,值是v
            while (rs.next()) {
                //一个空的map集合，用来存放每一行数据
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 0; i < count; i++) {
                    Object ob = rs.getObject(i + 1);//获取值
                    String key = rs.getMetaData().getColumnName(i + 1);//获取k即列名
                    map.put(key, ob);
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            close(rs, ps, con);
        }

        return null;
    }
}