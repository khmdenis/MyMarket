package com.org.mymarket.services.implementations;

import com.org.mymarket.dao.interfaces.ImageDAO;
import com.org.mymarket.model.Image;
import com.org.mymarket.services.interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDAO imageDao;

    @Override
    @Transactional
    public void add(Image obj) {
        imageDao.add(obj);
    }

    @Override
    @Transactional
    public void remove(Image obj) {
        imageDao.remove(obj);
    }

    @Override
    @Transactional
    public void update(Image obj) {
        imageDao.update(obj);
    }

    @Override
    @Transactional
    public Image getById(Long id) {
        return imageDao.getById(id);
    }

    @Override
    @Transactional
    public List<Image> getList() {
        return imageDao.getList();
    }
}
