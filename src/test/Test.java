package test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import classes.service.IScheduleService;
import classes.service.ScheduleServiceImpl;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import vo.ClassesVO;
import vo.FileVO;

public class Test {
	
	public static void main(String[] args) {
		
		IClassesService classService = ClassesServiceImpl.getInstance();
		IFileService fileService = FileServiceImpl.getInstance();

		List<ClassesVO> allClsList = classService.selectAll();
		List<List<FileVO>> allClsFileList = new ArrayList<List<FileVO>>();
		
		List<ClassesVO> craftClsList = classService.selectCraftCate();
		List<List<FileVO>> craftClsFileList = new ArrayList<List<FileVO>>();
		
		List<ClassesVO> cookClsList = classService.selectCookCate();
		List<List<FileVO>> cookClsFileList = new ArrayList<List<FileVO>>();
		
		List<ClassesVO> artClsList = classService.selectArtCate();
		List<List<FileVO>> artClsFileList = new ArrayList<List<FileVO>>();
		
		List<ClassesVO> flowerClsList = classService.selectFlowerCate();
		List<List<FileVO>> flowerClsFileList = new ArrayList<List<FileVO>>();
		
		List<ClassesVO> beautyClsList = classService.selectBeautyCate();
		List<List<FileVO>> beautyClsFileList = new ArrayList<List<FileVO>>();
		
		List<ClassesVO> actibityClsList = classService.selectActivityCate();
		List<List<FileVO>> actibityClsFileList = new ArrayList<List<FileVO>>();


		for (int i = 0; i < allClsList.size(); i++) {
			List<FileVO> allClsFilevo = fileService.getClassFileList(allClsList.get(i).getClsId());
			
			for (FileVO fileVO : allClsFilevo) {
				System.out.println(fileVO);
			}
			
			allClsFileList.add(allClsFilevo);
		}
		
		
		for (int i = 0; i < craftClsList.size(); i++) {
			
			List<FileVO> craftClsFilevo = fileService.getClassFileList(craftClsList.get(i).getClsId());
			
			for (FileVO fileVO : craftClsFilevo) {
				System.out.println(fileVO);
			}
			
			craftClsFileList.add(craftClsFilevo);
		}

		/*for (int i = 0; i < cookClsList.size(); i++) {
			List<FileVO> cookClsFilevo = fileService.getClassFileList(cookClsList.get(i).getClsId());

			cookClsFileList.add(cookClsFilevo);
		}
		for (int i = 0; i < artClsList.size(); i++) {
			List<FileVO> artClsFilevo = fileService.getClassFileList(artClsList.get(i).getClsId());

			artClsFileList.add(artClsFilevo);
		}
		for (int i = 0; i < flowerClsList.size(); i++) {
			List<FileVO> flowerClsFilevo = fileService.getClassFileList(flowerClsList.get(i).getClsId());

			flowerClsFileList.add(flowerClsFilevo);
		}
		for (int i = 0; i < beautyClsList.size(); i++) {
			List<FileVO> beautyClsFIlevo = fileService.getClassFileList(beautyClsList.get(i).getClsId());

			beautyClsFileList.add(beautyClsFIlevo);
		}
		for (int i = 0; i < actibityClsList.size(); i++) {
			List<FileVO> actClsFilevo = fileService.getClassFileList(actibityClsList.get(i).getClsId());

			actibityClsFileList.add(actClsFilevo);}*/
		
		
		
	}
	
}
