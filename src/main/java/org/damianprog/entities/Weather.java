package org.damianprog.entities;

public class Weather {
	private Query query;

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	@Override
	public String toString() {
		return "ClassPojo [query = " + query + "]";
	}
}
