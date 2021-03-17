public class ArrayList {
	private int size = 0;
	private Object[] elementData = new Object[100];
	
	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}
	
	public int size() {
		return size;
	}
	
	public int indexOf(Object o) {
		for(int i=0; i < size; i++) {
			if(o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}

	public ListIterator listIterator() {
		return new ListIterator(); 
	}
	
	class ListIterator{
		private int nextIndex = 0;

		public boolean hasNext() {
			return nextIndex < size();
		}

		public Object next() {
//			Object returnData = elementData[nextIndex];
//			nextIndex++;
//			return returnData;
			return elementData[nextIndex++];
		}
		
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;
		}
	}
}