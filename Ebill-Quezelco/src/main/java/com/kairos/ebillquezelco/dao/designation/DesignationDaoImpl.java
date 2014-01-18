package com.kairos.ebillquezelco.dao.designation;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kairos.ebillquezelco.dao.GenericDaoImpl;
import com.kairos.ebillquezelco.domain.designation.Designation;

@Repository("designationDao")
@Transactional
public class DesignationDaoImpl extends GenericDaoImpl<Designation, Long> implements DesignationDao {


}
