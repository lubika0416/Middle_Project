package comm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.service.ClassesServiceImpl;
import classes.service.IClassesService;
import comm.service.FileServiceImpl;
import comm.service.IFileService;
import vo.ClassesVO;
import vo.FileVO;

@WebServlet("/classlist.do")
public class ClassList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate = req.getParameter("cate");
		
		if (cate != null && !cate.equals("")) {
			req.getSession().setAttribute("cate", cate);
		}
		
		IClassesService classService = ClassesServiceImpl.getInstance();
		IFileService fileService = FileServiceImpl.getInstance();

		/* 전체 */
		List<ClassesVO> allClsList = classService.selectAll();
		List<List<FileVO>> allClsFileList = new ArrayList<List<FileVO>>();
		/* 공방 */
		List<ClassesVO> craftClsList = classService.selectCraftCate();
		List<List<FileVO>> craftClsFileList = new ArrayList<List<FileVO>>();
		/* 요리 */

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


		/* 전체 */
		for (int i = 0; i < allClsList.size(); i++) {
			List<FileVO> allClsFilevo = fileService.getClassFileList(allClsList.get(i).getClsId());

			allClsFileList.add(allClsFilevo);
		}
		/* 공방 */
		for (int i = 0; i < craftClsList.size(); i++) {
			List<FileVO> craftClsFilevo = fileService.getClassFileList(craftClsList.get(i).getClsId());
			craftClsFileList.add(craftClsFilevo);
		}

		for (int i = 0; i < cookClsList.size(); i++) {
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

			actibityClsFileList.add(actClsFilevo);
		}

		req.setAttribute("allClsList", allClsList);
		req.setAttribute("allClsFileList", allClsFileList);

		req.setAttribute("craftClsList", craftClsList);
		req.setAttribute("craftClsFileList", craftClsFileList);

		req.setAttribute("cookClsList", cookClsList);
		req.setAttribute("cookClsFileList", cookClsFileList);
		req.setAttribute("artClsList", artClsList);
		req.setAttribute("artClsFileList", artClsFileList);
		req.setAttribute("flowerClsList", flowerClsList);
		req.setAttribute("flowerClsFileList", flowerClsFileList);
		req.setAttribute("beautyClsList", beautyClsList);
		req.setAttribute("beautyClsFileList", beautyClsFileList);
		req.setAttribute("actibityClsList", actibityClsList);
		req.setAttribute("actibityClsFileList", actibityClsFileList);

		req.getRequestDispatcher("/WEB-INF/views/common/classList.jsp").forward(req, resp);
	}
}
