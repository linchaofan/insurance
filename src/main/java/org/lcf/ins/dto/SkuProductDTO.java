package org.lcf.ins.dto;

import java.io.Serializable;
import java.util.List;

public class SkuProductDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2718295261178562188L;

	public List<String> propvalnameList;
	
	@Override
	public boolean equals(Object obj) {
		// 如果为同一对象的不同引用,则相同
        if (this == obj) {
            return true;
        }
        // 如果传入的对象为空,则返回false
        if (obj == null) {
            return false;
        }

        // 如果两者属于不同的类型,不能相等
        if (getClass() != obj.getClass()) {
            return false;
        }

        // 类型相同, 比较内容是否相同
        SkuProductDTO other = (SkuProductDTO) obj;
        return !propvalnameList.retainAll(other.propvalnameList);
		
	}

	public List<String> getPropvalnameList() {
		return propvalnameList;
	}

	public void setPropvalnameList(List<String> propvalnameList) {
		this.propvalnameList = propvalnameList;
	}


	
	
	
}
