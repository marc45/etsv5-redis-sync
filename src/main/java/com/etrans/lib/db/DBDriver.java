package com.etrans.lib.db;
/**
 * 版权所有 (C) 2016 ® E-trans Company  <br />
 * 单元名称: DBDriver.java  <br />
 * 说       明: 数据库类型<br />
 * 作       者: mous <br />
 * 创建时间: 2016年8月23日 下午4:25:25 <br />
 * 最后修改: 2016年8月23日 下午4:25:25 <br />
 * 修改历史: <br />
 */
public enum DBDriver {
    UNKNOWN(0),
    MYSQL(1),
    MSSQL(2),
    ORACLE(3),
    SQLITE(4);

    private final int value;

    DBDriver(int _value) {
        value = _value;
    }

    public int getValue() {
        return value;
    }

    public static DBDriver valueOf(int _value) {
        switch (_value) {
            case 1:
                return MYSQL;
            case 2:
                return MSSQL;
            case 3:
                return ORACLE;
            case 4:
                return SQLITE;
            default:
                return UNKNOWN;
        }
    }

    public static DBDriver valueOfName(String _key) {
        if (MYSQL.getName().equals(_key)) 
        	return MYSQL;
        else if (MSSQL.getName().equals(_key)) 
        	return MSSQL;
        else if (ORACLE.getName().equals(_key)) 
        	return ORACLE;
        else if (SQLITE.getName().equals(_key)) 
        	return SQLITE;
        else 
        	return UNKNOWN;
    }

    public String getName() {
        switch (this) {
            case MYSQL:
                return "mysql";
            case MSSQL:
                return "mssql";
            case SQLITE:
                return "sqlite";
            case ORACLE:
                return "oracle";
            default:
                break;
        }
        return "mysql";
    }

    public String getDriverClass() {
        switch (this) {
            case MYSQL:
                return "com.mysql.jdbc.Driver";
            case MSSQL:
                return "net.sourceforge.jtds.jdbc.Driver";
            //return "com.microsoft.jdbc.sqlserver.SQLServerDriver";
            case SQLITE:
                return "org.sqlite.JDBC";
            case ORACLE:
                return "oracle.jdbc.driver.OracleDriver";
            default:
                break;
        }
        return "com.mysql.jdbc.Driver";
    }

    /**
     * 返回数据库连接URL
     * @param _host 主机
     * @param _port 端口
     * @param _name 库名
     * @return 连接URL
     */
    public String getConnectionURL(String _host, int _port, String _instance, String _name) {
        String fmt = "";
        switch (this) {
            case MYSQL:{
                if (0 == _port)
                    _port = 3306;
                fmt = "jdbc:mysql://@host:@port/@name?useUnicode=true&characterEncoding=GBK";
            } break;
                
            case MSSQL:{
                if (0 == _port)
                    _port = 1433;
                fmt = "jdbc:jtds:sqlserver://@host:@port;instance=@instance;DatabaseName=@name;charset=GBK";
            } break;
                
            case ORACLE:{
                if (0 == _port)
                    _port = 1521;
                fmt = "jdbc:oracle:thin:@host:@port:@name";
            } break;
                
            case SQLITE:{
                fmt = "jdbc:sqlite:@name";
            } break;
                
            default: break;
        }
        
        String port = "" + _port;
        if(null == _instance)
        	_instance = "";
        
        return fmt.replace("@name", _name)
		          .replace("@port", port)
		          .replace("@instance", _instance)
		          .replace("@host", _host);
    }

}
