package org.test;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.Struct;
import java.sql.Types;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class App {
	public static void main(String[] args) throws Exception {
		
		final String typeName = "OTR_FM";
		Connection connection = null;		

		// Obtener una descripción de su tipo (específico de Oracle)

		connection = getOracleConnection();

		final StructDescriptor structDescriptor = StructDescriptor.createDescriptor(typeName.toUpperCase(), connection);

		final ResultSetMetaData metaData = structDescriptor.getMetaData();

		final StructDescriptor structDescriptor2 = StructDescriptor.createDescriptor("OTR_FM_HEADER", connection);

		final ResultSetMetaData metaData2 = structDescriptor2.getMetaData();

		final StructDescriptor structDescriptor3 = StructDescriptor.createDescriptor("OTR_SES_ATTR", connection);

		final ResultSetMetaData metaData3 = structDescriptor3.getMetaData();

		// Llamar al procedimiento (o lo que sea) que devuelve la tabla de un
		// tipo personalizado

		CallableStatement cs = connection.prepareCall("{call PKG_CHR_CHARGES_CALL.PRO_RUN(?)}");

		// El resultado es un java.sql.Array ...

		cs.registerOutParameter(1, Types.STRUCT, typeName);

		cs.execute();

		STRUCT data = (STRUCT) cs.getObject(1);

		int idx = 1;
		for (Object attribute : data.getAttributes()) {

			// if ( metaData.getColumnType(idx) == Types.STRUCT ||
			// metaData.getColumnType(idx) == Types.ARRAY )
			if (metaData.getColumnType(idx) == Types.STRUCT) {
				System.out.println("\t" + metaData.getColumnName(idx) + " = " + attribute);
				STRUCT xxx = (STRUCT) attribute;
				int idy = 1;
				for (Object attribute2 : xxx.getAttributes()) {
					System.out.println(metaData2.getColumnName(idy) + " = " + attribute2);
					idy++;
				}

			} else if (metaData.getColumnType(idx) == Types.ARRAY && metaData.getColumnName(idx) == "ATTRLIST") {

				Object[] data_ = (Object[]) ((Array) attribute).getArray();

				for (Object tmp : data_) {

					Struct row = (Struct) tmp;

					// Los atributos están basados ​​en el índice 1...

					int idz = 1;

					for (Object attribute__ : row.getAttributes()) {

						System.out.println("=>" + metaData3.getColumnName(idz) + " = " + attribute__);
						++idz;

					}

					System.out.println("---");

				}

			} else {
				System.out.println(metaData.getColumnName(idx) + " = " + attribute);
			}

			++idx;

		}


		cs.close();

	}

	public static Connection getOracleConnection() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.240:1521:DB11G";
		String username = "MFB";
		String password = "MFB";

		Class.forName(driver); // load Oracle driver
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
}
