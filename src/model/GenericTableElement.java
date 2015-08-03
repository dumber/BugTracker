/**
 * 
 */
package model;

/**
 * @author dumber
 *
 */
public class GenericTableElement { //<T extends GenericTableElement<T>> {
	protected int id;
//	public Class<? extends GenericTableElement<T>> type;
	
	/**
	 * 
	 */
	public GenericTableElement(int id) {
		this.id = id;
	}

//	/**
//	 * 
//	 */
//	public GenericTableElement(int id, Class<? extends GenericTableElement<T>> type) {
//		this.id = id;
//		this.type = type;
//	}
//	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

//	/**
//	 * @return the type
//	 */
//	protected Class<? extends GenericTableElement<T>> getType() {
//		return type;
//	}
//
//	/**
//	 * @param type the type to set
//	 */
//	protected void setType(Class<? extends GenericTableElement<T>> type) {
//		this.type = type;
//	}
	
	
}
