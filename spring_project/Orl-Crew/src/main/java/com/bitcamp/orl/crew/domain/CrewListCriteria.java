package com.bitcamp.orl.crew.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrewListCriteria {
	private int page; // 보여줄 페이지
    private int perPageNum = 6; // 페이지당 보여줄 페이지수
 
    public CrewListCriteria() {
    	this.page = 1;
    }
    
    public CrewListCriteria(int page){
        this.page = page;
    }
    
    public int getPageStart(){
        return (this.page -1) * this.perPageNum;
    }
 
    public void setPage(int page) {
        if ( page <= 0 ){
            // 페이지는 1페이지부터임으로 0보다 작거나 같은값일 경우 무조건 첫번째 페이지로 설정되도록 해준다.
            this.page = 1;
        }else{
            this.page = page;
        }
    }
    
    public void setPerPageNum(int perPageNum) {
        if ( perPageNum <= 0 || perPageNum > 100 ) {
            this.perPageNum = 10;
        }else {
            this.perPageNum = perPageNum;
        }
    }
     
}
