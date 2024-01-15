package producer.service;

import java.util.List;

import producer.dao.FeedDaoImpl;
import producer.dao.IFeedDao;
import vo.FeedVO;

public class FeedServiceImpl implements IFeedService{
	
	private static IFeedService feedService;
	
	private IFeedDao feedDao;
	
	private FeedServiceImpl() {
		feedDao = FeedDaoImpl.getInstance();
	}
	
	public static IFeedService getInstance() {
		if (feedService == null) feedService = new FeedServiceImpl();
		return feedService;
	}

	@Override
	public List<FeedVO> getFeedList(String proId) {
		return feedDao.getFeedList(proId);
	}

	@Override
	public int insertFeed(FeedVO fdv) {
		return feedDao.insertFeed(fdv);
	}

	@Override
	public FeedVO getFeed(int feedNo) {
		return feedDao.getFeed(feedNo);
	}

	@Override
	public int getFileId(int feedNo) {
		return feedDao.getFileId(feedNo);
	}

	@Override
	public int updateFeed(FeedVO fdv) {
		return feedDao.updateFeed(fdv);
	}

	@Override
	public int deleteFeed(int feedNo) {
		return feedDao.deleteFeed(feedNo);
	}

	@Override
	public List<FeedVO> selectFeed() {
		return feedDao.selectFeed();
	}

}
