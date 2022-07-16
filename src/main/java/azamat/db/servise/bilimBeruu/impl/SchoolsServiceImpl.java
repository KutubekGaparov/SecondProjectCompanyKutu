package azamat.db.servise.bilimBeruu.impl;

import azamat.exceptions.BadRequestException;
import azamat.model.entity.bilimBeruu.Schools;
import azamat.db.repository.bilimPeruu.SchoolsRepository;
import azamat.db.servise.bilimBeruu.SchoolsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolsServiceImpl implements SchoolsService {

    private SchoolsRepository schoolsRepository;

    @Override
    public Schools saveSchools(Schools schools) {
        return schoolsRepository.save(schools);
    }

    @Override
    @Transactional
    public Schools update(Schools schools, Long id) {
        Schools moeEvent = schoolsRepository.findById(id).orElseThrow(() ->
                new BadRequestException(String.format("User with id %s has not been found", id)));

        String oldText = moeEvent.getText();
        String newText = schools.getText();
        if (!oldText.equals(newText)) {
            moeEvent.setText(newText);
        }
        String oldName = moeEvent.getText();
        String newName = schools.getText();
        if (!oldName.equals(newName)) {
            moeEvent.setSchoolName(newName);
        }
        String oldFullName = moeEvent.getText();
        String newFullName = schools.getText();
        if (!oldFullName.equals(newFullName)) {
            moeEvent.setDirectorFullName(newFullName);
        }
        String oldAddress = moeEvent.getText();
        String newAddress = schools.getText();
        if (!oldAddress.equals(newAddress)) {
            moeEvent.setAddress(newAddress);
        }
        String oldNum = moeEvent.getText();
        String newNum = schools.getText();
        if (!oldNum.equals(newNum)) {
            moeEvent.setText(newNum);
        }

        return moeEvent;
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        schoolsRepository.deleteById(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @Override
    public List<Schools> getAll() {
        return schoolsRepository.findAll();
    }
}
