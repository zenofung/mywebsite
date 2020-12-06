package com.website.company.service;

import com.website.company.utils.AreaVO;

import java.util.List;

public interface AreaPart {

    public List<AreaVO> getNorth_city();

    public List<AreaVO> getEast_city();

    public List<AreaVO> getCenter_city();

    public List<AreaVO> getNortheast_city();

    public List<AreaVO> getNorthwest_city();

    public List<AreaVO> getSouth_city();

    public List<AreaVO> getSouthwest_city();

}
