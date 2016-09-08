package control;

import android.util.TypedValue;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class ui {

	public static int page_width;
	public static int page_height;
	public static int corel_width;
	public static int corel_height;

	static public float object_ratio;
	static public float width_ratio;
	static public float height_ratio;

	public ui(int w, int h) {
		sizing display_sizing = new sizing(w, h);
		object_ratio = display_sizing.get_object_ratio(w, h);
		width_ratio = display_sizing.calc_width_ratio(w);
		height_ratio = display_sizing.calc_height_ratio(h);
		page_width = w; // screen width
		page_height = h;// screen height
		corel_height = (int) (h / height_ratio);
		corel_width = (int) (w / width_ratio);
	}

	public static ImageView image_view(ImageView img, int width, int height,int x, int y) {

		img.getLayoutParams().width = (int) ((width * width_ratio));
		img.getLayoutParams().height = (int) ((height * height_ratio));
		AbsoluteLayout.LayoutParams position = (AbsoluteLayout.LayoutParams) img
				.getLayoutParams();
		position.x = (int) (x * width_ratio);
		position.y = (int) (y * height_ratio);
		img.setLayoutParams(position);
		return img;

	}
	
	public static Button button(Button btn, int width, int height,int x, int y) {

		btn.getLayoutParams().width = (int) ((width * width_ratio));
		btn.getLayoutParams().height = (int) ((height * height_ratio));
		AbsoluteLayout.LayoutParams position = (AbsoluteLayout.LayoutParams) btn
				.getLayoutParams();
		position.x = (int) (x * width_ratio);
		position.y = (int) (y * height_ratio);
		btn.setLayoutParams(position);
		return btn;

	}
	
	public static Spinner spinner(Spinner spi, int width, int height,int x, int y) {

		spi.getLayoutParams().width = (int) ((width * width_ratio));
		spi.getLayoutParams().height = (int) ((height * height_ratio));
		AbsoluteLayout.LayoutParams position = (AbsoluteLayout.LayoutParams) spi
				.getLayoutParams();
		position.x = (int) (x * width_ratio);
		position.y = (int) (y * height_ratio);
		spi.setLayoutParams(position);
		return spi;

	}
	
	
	
	public static EditText edittext(EditText txt, int width, int height,int x, int y) {

		txt.getLayoutParams().width = (int) ((width * width_ratio));
		txt.getLayoutParams().height = (int) ((height * height_ratio));
		AbsoluteLayout.LayoutParams position = (AbsoluteLayout.LayoutParams) txt
				.getLayoutParams();
		position.x = (int) (x * width_ratio);
		position.y = (int) (y * height_ratio);
		txt.setLayoutParams(position);
		return txt;

	}

	public static TextView textview(TextView txt, int x, int y, int text_size) {
		txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, text_size * width_ratio);
		AbsoluteLayout.LayoutParams position = (AbsoluteLayout.LayoutParams) txt
				.getLayoutParams();
		position.x = (int) (x * width_ratio);
		position.y = (int) (y * height_ratio);
		txt.setLayoutParams(position);
		return txt;
	}
	
	
}
