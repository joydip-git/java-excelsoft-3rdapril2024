package com.restapi.sample.models.services;

import java.sql.SQLException;
import java.util.List;

public interface ServiceContract<TModel, TKey> {
	List<TModel> fetchRecords(int sortingChoice) throws ClassNotFoundException, SQLException, Exception;

	TModel fetchRecord(TKey id) throws ClassNotFoundException, SQLException, Exception;

	TModel insertRecord(TModel modelObject) throws ClassNotFoundException, SQLException, Exception;

	TModel modifyRecord(TKey id, TModel modelObject) throws ClassNotFoundException, SQLException, Exception;

	Integer removeRecord(TKey id) throws ClassNotFoundException, SQLException, Exception;
}
