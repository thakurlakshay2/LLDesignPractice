package LockerManagementSystem.repository;

import LockerManagementSystem.model.Locker;
import LockerManagementSystem.model.Size;
import LockerManagementSystem.model.Slot;

import java.util.List;

public interface ILockerRepository {

    Locker createLocker(String id);

     Slot createSlot(final Locker locker, final Size slotSize);

     void deallocateSlot(final Slot slot);
     List<Slot> getAllAvailableSlots();
}
