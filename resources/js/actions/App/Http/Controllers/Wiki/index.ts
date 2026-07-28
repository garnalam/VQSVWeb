import PetController from './PetController'
import SkillController from './SkillController'
import ItemController from './ItemController'
const Wiki = {
    PetController: Object.assign(PetController, PetController),
SkillController: Object.assign(SkillController, SkillController),
ItemController: Object.assign(ItemController, ItemController),
}

export default Wiki