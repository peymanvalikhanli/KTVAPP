package control;



public class sizing {

	private static final int defult_width=955; 
	private static final int  defult_height=1592; 
	private float width_ratio; 
	private float height_ratio; 
	private float min_ratio; 
	
	public sizing(float current_width,float current_height){
		
		calc_width_ratio(current_width);
		calc_height_ratio(current_height);
	}
		
	public float calc_width_ratio(float current_width){

		return this.width_ratio=(float)current_width / (float)this.defult_width;
	}

	public float calc_height_ratio(float current_height){
		
		return this.height_ratio=(float)current_height/(float)this.defult_height;
	}

	private void calc_min_ratio(){
		
		
		if(this.width_ratio<=this.height_ratio)
			this.min_ratio=this.width_ratio; 
		else 
			this.min_ratio=this.height_ratio;
	}
	
	public float get_object_ratio(int current_width,int current_height){
		
		calc_width_ratio(current_width);
		calc_height_ratio(current_height);
		
		calc_min_ratio();
		
		return this.min_ratio;
	}
	
	public float X_offset(int current_width,int current_height) {
	
		float offset=current_width-get_object_ratio(current_width, current_height)*this.defult_width; 
		offset/=2;
		return offset;
	}
	
	public float Y_offset(int current_width,int current_height) {

		float offset=current_height-get_object_ratio(current_width, current_height)*this.defult_height; 
		offset/=2; 
		return offset;
	}

}
