package control;

import android.os.Environment;

public class Vars {

	public static final String Register_path= Environment.getExternalStorageDirectory()+"/KTV/Register.csv";
	public static final String Register_folder= Environment.getExternalStorageDirectory()+"/KTV";
	
	public static final String Type_path= Environment.getExternalStorageDirectory()+"/KTV/Type.csv";
	public static final String Company_path= Environment.getExternalStorageDirectory()+"/KTV";
	public static final String Application_path= Environment.getExternalStorageDirectory()+"/KTV";
	public static final String Ancill_path= Environment.getExternalStorageDirectory()+"/KTV";
	
	public static String Inlet_pressure;
	public static String Inlet_temprature;
	public static String Outlet_pressure;
	public static String Application;
	public static String Type;
	public static String Position;
	public static String Connection;
	public static String Size;
	public static String Ancillary_Equipment;
	public static String Company;
	public static String Nots; 
	public static String Attachment; 
	public static String Date;
	public static String V_Export;
	
	public static final String Help = "این برنامه به شکلی طراحی شده است که به ساده ترین روش ممکن امکان استفاده آن برای کاربر فراهم آید. این برنامه دارای منوهای زیر است که به اختصار کاربرد هریک توضیح داده شده است.\n1- فرم ثبت: \n\nاین منو به منظور ثبت اطلاعات دستگاه ها طراحی شده است. لازم است توجه داشته باشید که درج اطلاعات هر فیلد باید با دقت صورت پذیرد زیرا صحت اطلاعات ورودی توسط متخصصی که در حال ثبت اطلاعات است سنجیده می گردد.\n2- خروجی اکسل:\n\nبا این گزینه شما می توانید خروجی اطلاعات ثبت شده را به صورت انبوه بر روی اکسل دریافت کنید. لازم به توضیح است هر مرحله که خروجی اطلاعات گرفته می شود، تا مرحله بعد که مجدداً این درخواست صادر می گردد تنها داده هایی که در این بازه زمانی ثبت شده اند در فایل خروجی نمایش داده خواهند شد.\n3- تنظیمات:\n\nاین منو تنها در زمان اولین اجرا پس از نصب برنامه با فایل تنظیماتی که به آن داده می شود مقادیر پیش فرض فیلدهای Type، Application، Ancillary equipment و Company را تنظیم می نماید. لازم به توضیح است چنانچه تنظیمات برنامه با مشکلی مواجه شد و یا نیازمند بروزرسانی بود کافی فایل جدید تنظیمات را وارد نمایید.  \n4- انتقال به سرور:\nاین منو در ورژن های بعدی فعال خواهد شد و در حال حاضر غیر قابل استفاده می باشد.\n5- درباره ما:\nدر این صفحه شما می توانید اطلاعات مربوط به تولید کننده نرم افزار را مشاهده نمایید.\n"; 
	public static final String About = "این برنامه توسط شرکت بارمان طراحی شده است. این شرکت در زمینه طراحی انواع نرم افزارهای دسکتاپ و موبایل مستقل از سیستم عامل تجارب بسیاری دارد. برای اطلاعات بیشتر می توانید از طریق آدرس زیر با ما در تماس باشید. \n support@btap.ir";
	public static int page_type;
}
