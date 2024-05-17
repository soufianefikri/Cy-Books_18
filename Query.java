package testapi;

import java.util.List;

/**
 * Query is the class that generate valid queries for the ApiCaller
 * 
 * @author Theo Seng
 */

public class Query {
	/**
	 * This is a list of all the relations that can be used in every query
	 */
	public enum Relation{
		ANY,
		ALL,
		ADJ;
	}
	/**
	 * This is a list of all the relations that can be used in searchByDate
	 */
	public enum DateRelation{
		ANY("any"),
		ALL("all"),
		ADJ("adj"),
		BEFORE("<"),
		DURING("="),
		AFTER(">");
		
		private final String strRelation;
		
		DateRelation(String strRelation){
			this.strRelation=strRelation;
		}
	}
	
	/**
	 * The main query builder that is used by the others functions of Query
	 * 
	 * @param search is the string in the URL that defines on what criteria is done the search
	 * @param term is the string in the URL that the user inputed
	 * @param relation refers to the enum Relation
	 * @return a valid query that can be used in the call function of ApiCaller
	 */
	private static String search(String search,String term,Relation relation) {
		String query=search;
		query=query+relation;
		query=query+" \""+term+"\"";
		return query;
	}
	
	
	/**
	 * Function used to create a query to search a term anywhere in books' entries in the BNF's API
	 * 
	 * @param term is the string in the URL that the user inputed
	 * @param relation refers to the enum Relation
	 * @return a valid query that can be used in the call function of ApiCaller
	 */
	public static String generalSearch(String term,Relation relation) {
		String query = Query.search("bib.anywhere ",term,relation);
		return query;
	}
	/**
	 * Function used to create a query to search a term in the authors' name
	 * 
	 * @param term is the string in the URL that the user inputed
	 * @param relation refers to the enum Relation
	 * @return a valid query that can be used in the call function of ApiCaller
	 */
	public static String searchByAuthor(String term,Relation relation) {
		String query = Query.search("bib.author ",term,relation);
		return query;
	}
	/**
	 * Function used to create a query to search a term in the titles of the books
	 * 
	 * @param term is the string in the URL that the user inputed
	 * @param relation refers to the enum Relation
	 * @return a valid query that can be used in the call function of ApiCaller
	 */
	public static String searchByTitle(String term,Relation relation) {
		String query = Query.search("bib.title ",term,relation);
		return query;
	}
	/**
	 * Function used to create a query to search a term in the subject section of the books' entries
	 * 
	 * @param term is the string in the URL that the user inputed
	 * @param relation refers to the enum Relation
	 * @return a valid query that can be used in the call function of ApiCaller
	 */
	public static String searchBySubject(String term,Relation relation) {
		String query = Query.search("bib.subject ",term,relation);
		return query;
	}
	/**
	 * Function used to create a query to search books by using a date(YYYY format)
	 * 
	 * @param year is a date using the YYYY format
	 * @param relation refers to the enum Relation
	 * @return a valid query that can be used in the call function of ApiCaller
	 */
	public static String searchByDate(String year,DateRelation relation) {
		String query="bib.publicationdate ";
		query=query+relation.strRelation;
		query=query+" \""+year+"\"";
		return query;
	}
	/**
	 * Function used to create a query to search books by language
	 * 
	 * @param term is a string that can be the name of a language or the BNF's norms for abbreviating languages' names
	 * @param relation refers to the enum Relation
	 * @return a valid query that can be used in the call function of ApiCaller
	 */
	public static String searchByLanguage(String term,Relation relation) {
		String query = Query.search("bib.language ",term,relation);
		return query;
	}
	/**
	 * Function used to create a query to search books by using the ISBN
	 * 
	 * @param term is a string containing the ISBN the user wants to search
	 * @param relation refers to the enum Relation
	 * @return a valid query that can be used in the call function of ApiCaller
	 */
	public static String searchByISBN(String term,Relation relation) {
		String query = Query.search("bib.isbn ",term,relation);
		return query;
	}
}
