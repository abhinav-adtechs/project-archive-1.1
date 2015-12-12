package com.archive.jordiie.onboardingscreen.Handlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.archive.jordiie.onboardingscreen.CourseRef;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordiie on 11/12/15.
 */
public class DBHandler extends SQLiteOpenHelper {


    //Need 3 Tables: Courses, Chats, Notes Links


    private static final int DATABASE_VERSION = 3 ;


    private static final String DATABASE_NAME = "DatabaseArchive";

    //Table Courses
    private static final String TABLE_ARCHIVE = "Courses" ;

    private static final String C_CLASSNO = "course_class_number";
    private static final String C_TITLE = "course_title";
    private static final String C_CODE = "course_code";
    private static final String C_ATTENDANCE = "course_attendance";

    private static final String[] COLUMNS = {C_CLASSNO, C_CODE, C_TITLE, C_ATTENDANCE};

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ARCHIVE + "{" +
                C_CLASSNO + " INTEGER PRIMARY KEY " +
                C_CODE + " INTEGER " +
                C_TITLE + " TEXT " +
                C_ATTENDANCE + " INTEGER " +
                "};" ;

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARCHIVE);
    }

    public void saveCourses(List<CourseRef> courses) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();


            for (int i = 0; i < courses.size(); i++) {
                CourseRef course = courses.get(i);

                ContentValues values = new ContentValues();

                values.put(COLUMNS[0], course.getCLASS_NUMBER());
                values.put(COLUMNS[1], course.getCOURSE_TITLE());
                values.put(COLUMNS[2], course.getCOURSE_CODE());
                //values.put(COLUMNS[3], course.getCOURSE_ATTENDANCE().getJson().toString());
                if(check()) {
                    Log.d("update","check()");
                    db.replace(TABLE_ARCHIVE,null,values);
                    //db.update(TABLE_COURSES, values, null, null);
                }
                else {
                    Log.d("insert","check()");
                    db.insert(TABLE_ARCHIVE, null, values);
                }
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
            SQLiteDatabase _db = this.getWritableDatabase();
            if (_db != null && _db.isOpen()) {
                _db.close();
            }
        }

    }

    public CourseRef getCourse(String classNmbr) {
        CourseRef course = new CourseRef();
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursor = db.query(TABLE_ARCHIVE, COLUMNS, C_CLASSNO + "=?", new String[]{String.valueOf(classNmbr)}, null, null, null, null);

            if (cursor != null)
                cursor.moveToFirst();

            course.setCLASS_NUMBER(cursor.getString(0));
            course.setCOURSE_TITLE(cursor.getString(1));
            course.setCOURSE_CODE(cursor.getString(2));
           // course.setCOURSE_ATTENDANCE(ParseCourses.getAttendance(new JSONObject(cursor.getString(3))));

            cursor.close();
            db.close();

        } catch (Exception e) {
            e.printStackTrace();
            SQLiteDatabase _db = this.getWritableDatabase();
            if (_db != null && _db.isOpen()) {
                _db.close();
            }
        }


        return course;
    }

    public int getCoursesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ARCHIVE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();
        db.close();

        return count;
    }

    public List<CourseRef> getCoursesList() {
        List<CourseRef> courses = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_ARCHIVE;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    CourseRef course = new CourseRef();
                    course.setCLASS_NUMBER(cursor.getString(0));
                    course.setCOURSE_TITLE(cursor.getString(1));
                    course.setCOURSE_CODE(cursor.getString(2));
                    //course.setCOURSE_ATTENDANCE(ParseCourses.getAttendance(new JSONObject(cursor.getString(3))));
                    courses.add(course);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
            SQLiteDatabase _db = this.getWritableDatabase();
            if (_db != null && _db.isOpen()) {
                _db.close();
            }
        }
        return courses;
    }

    public Boolean check() {
        String countQuery = "SELECT  * FROM " + TABLE_ARCHIVE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if (cursor == null || !cursor.moveToFirst() ) {
            return false;
        } else
            return true;
    }

    public void clear(){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String deleteQuery="DELETE FROM "+TABLE_ARCHIVE+";";
        sqLiteDatabase.delete(TABLE_ARCHIVE,"1",null);
        Cursor cursor = sqLiteDatabase.rawQuery(deleteQuery, null);
        cursor.close();
        sqLiteDatabase.close();
    }

}
