package com.mongodbrest.repositories;

import java.util.List;

import com.mongodb.WriteResult;
import com.mongodbrest.models.*;

public interface Repository {

	public List<Tree> getAllTrees();

	public void saveTree(Tree tree);

	public Tree getTree(String id);

	public WriteResult updateTree(String id, String name);

	public void deleteTree(String id);

	public void createCollection();

	public void dropCollection();

	public WriteResult updateT(String treeId, String name, int age);
}
