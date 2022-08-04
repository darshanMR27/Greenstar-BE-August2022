package com.outreach.greenstar.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.outreach.greenstar.entities.Cls;
import com.outreach.greenstar.entities.Group;
import com.outreach.greenstar.entities.Section;
import com.outreach.greenstar.exeption.GroupNotFoundException;
import com.outreach.greenstar.repository.ClassRepository;
import com.outreach.greenstar.repository.GroupRepository;
import com.outreach.greenstar.repository.SectionRepository;

@Repository("groupDao")
public class GroupDao {

    @Autowired
    private GroupRepository groupRepo;
    
    @Autowired
    private SectionRepository sectionRepo;
    
    @Autowired
    private ClassRepository classRepository;
    
    /*@Autowired
    private SchoolRepository schoolRepository;*/
    
    public Group getGroupById(int groupId) {
        Group group = null;
        try {
            group = groupRepo.getOne(groupId);
        } catch (Exception e) {
            throw new GroupNotFoundException("Invalid Group ID = "+groupId);
        }
        return group;
    }

    public List<Group> getGroupBySection(int sectionId) {
        Optional<Section> sectionOption = sectionRepo.findById(sectionId);
        if (sectionOption.isPresent()) {
            return groupRepo.findBySection(sectionOption.get());
        }
        return Collections.emptyList();
    }

    public List<Group> getGroupByClass(int classId) {
        Optional<Cls> clsOpt = classRepository.findById(classId);
        if (clsOpt.isPresent()) {
            return groupRepo.findByCls(clsOpt.get());
        }
        return Collections.emptyList();
    }

    @Transactional
    public Group createOrUpdateGroup(Group grp) {
        return groupRepo.saveAndFlush(grp);
    }

    public void deleteGroup(Group group) {
        groupRepo.delete(group);
        groupRepo.flush();
    }

    /*public List<Group> getGroupBySchool(int schoolId) {
        Optional<School> schoolOpt = schoolRepository.findById(schoolId);
        if (schoolOpt.isPresent()) {
            return groupRepo.findBySchool(schoolOpt.get());
        }
        return Collections.emptyList();
    }*/

}
